class 1288 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect14
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.el_aura_burn_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect19
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_aura_flare_ta'
		bOnMultiTarget=True
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect22
		AttachOn=AM_LA
		SpawnDelay=0.200000
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_aura_flare_ta'
		bOnMultiTarget=True
	End Object
	Desc="오라 심포니" //Aura Symphony
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect14',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect19',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect22',SpecificStage=0)
}