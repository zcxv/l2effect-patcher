class 4707 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_heal_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ab_bleeding'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_heal_ta'
		bOnMultiTarget=True
	End Object
	Desc="셰이크 새크리파이스" //Pais new creative Sheikh
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}