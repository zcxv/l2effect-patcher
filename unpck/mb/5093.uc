class 5093 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect31
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.e_u828_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect32
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.e_u828_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect80
		SpawnDelay=0.400000
		offset=(X=6.000000,Y=5.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.e_u828_conestone_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect81
		SpawnDelay=0.200000
		offset=(X=7.000000,Y=5.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.e_u828_conestone_ta'
	End Object
	Desc="안타라스메테오" //Meteor Antharas
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect31',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect32',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect80',SpecificStage=0)
	ShotActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect81',SpecificStage=0)
}