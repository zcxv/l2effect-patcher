class 1237 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.800000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_ice_dagger_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect15
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=2.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.el_ice_dagger_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect17
		EffectClass=Class'LineageEffect.el_ice_dagger_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect16
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_ice_dagger_ta'
	End Object
	Desc="아이스 대거" //Ice Dagger
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect15',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect17',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect16',SpecificStage=0)
	FlyingTime=0.400000
}