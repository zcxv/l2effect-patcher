class 346 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.oa_force_rage_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.oa_force_rage_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.mo_battle_roar_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.oa_force_rage_ta'
	End Object
	Desc="포스 레이지" //Force Rage
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	FlyingTime=0.400000
}